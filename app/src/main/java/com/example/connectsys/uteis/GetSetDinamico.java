package com.example.connectsys.uteis;

import android.database.Cursor;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Jose on 02/06/2017.
 */

public class GetSetDinamico {

    public Object insereField(Field field, Object objetoRecebido, Object recebido) {
        String primeiro = field.getName().substring(0, 1);
        String nomeCampo = field.getName().substring(1);
//        Object objetoInstanciado = null;
        try {
//            objetoInstanciado = Class.forName(objetoRecebido.getClass().toString().replace("class ","")).newInstance();
//            objetoInstanciado = objetoRecebido;
            Class[] cArg = new Class[1];
            if (recebido != null) {
                if (field.getType().getSimpleName().toUpperCase().equals("STRING") || field.getType().getSimpleName().toUpperCase().equals("EDITTEXT")) {
                    cArg[0] = String.class;
                    Method method = objetoRecebido.getClass().getMethod("set" + primeiro.toUpperCase() + nomeCampo,
                            field.getType());
                    method.invoke(objetoRecebido, recebido.toString());
                } else if (field.getType().getSimpleName().toUpperCase().equals("DATE")) {
                    cArg[0] = Date.class;
                    Method method = objetoRecebido.getClass().getMethod("set" + primeiro.toUpperCase() + nomeCampo,
                            field.getType());
                    Date data = new Date();
                    data.setTime(Long.parseLong(recebido.toString()));
                    method.invoke(objetoRecebido, data);
                } else if (field.getType().getSimpleName().toUpperCase().equals("LONG")) {
                    cArg[0] = Long.class;
                    Method method = objetoRecebido.getClass().getMethod("set" + primeiro.toUpperCase() + nomeCampo,
                            field.getType());
                    method.invoke(objetoRecebido, Long.parseLong(recebido.toString()));
                } else if (field.getType().getSimpleName().toUpperCase().equals("DOUBLE")) {
                    cArg[0] = Double.class;
                    Method method = objetoRecebido.getClass().getMethod("set" + primeiro.toUpperCase() + nomeCampo,
                            field.getType());
                    method.invoke(objetoRecebido, Double.parseDouble(recebido.toString()));
                } else if (field.getType().getSimpleName().toUpperCase().equals("BOOLEAN")) {
                    cArg[0] = Boolean.class;
                    Method method = objetoRecebido.getClass().getMethod("set" + primeiro.toUpperCase() + nomeCampo,
                            field.getType());
                    method.invoke(objetoRecebido, Boolean.parseBoolean(recebido.toString()));
                }
            }
            return objetoRecebido;
        } catch (IllegalAccessException e) {
            Log.i("IllegalAccessException", "ACESSO ILEGAL");
        } catch (NoSuchMethodException e) {
            Log.i("NoSuchMethodException", "METODO NAO ENCONTRADO," + primeiro.toUpperCase() + nomeCampo);
        } catch (SecurityException e) {

        } catch (IllegalArgumentException e) {

        } catch (InvocationTargetException e) {

//        } catch (ClassNotFoundException e) {
//
//        } catch (InstantiationException e) {

        }
        return objetoRecebido;
    }

    public String retornaTipoCampo(Field field) {
        String tipo = field.getType().getSimpleName().toUpperCase();
        return tipo;
    }

    public Object retornaValorCursor(String tipo, String nome, Cursor cursor1) {
        Object objeto = null;
        if (nome.equals("$change") || nome.equals("serialversionuid") || nome.equals("context")) {

        } else {
            if (tipo.equals("STRING") || tipo.equals("EDITTEXT")) {
                objeto = cursor1.getString(cursor1.getColumnIndex(nome));
            } else if (tipo.equals("LONG")) {
                objeto = cursor1.getLong(cursor1.getColumnIndex(nome));
            } else if (tipo.equals("DATE")) {
                objeto = cursor1.getLong(cursor1.getColumnIndex(nome));
            } else if (tipo.equals("INT")) {
                objeto = cursor1.getInt(cursor1.getColumnIndex(nome));
            } else if (tipo.equals("DOUBLE")) {
                objeto = cursor1.getDouble(cursor1.getColumnIndex(nome));
            } else if (tipo.equals("BOOLEAN") || tipo.equals("CHECKBOX")) {
                objeto = cursor1.getInt(cursor1.getColumnIndex(nome)) == 1;
            }
        }
        return objeto;
    }


    public Object setValorObjetoCursor(Field field, Object object, Cursor cursor) {
        String tipo = retornaTipoCampo(field);
        Object retorno = null;
        if (field.getName().toLowerCase().equals("$change") || field.getName().toLowerCase().equals("serialversionuid") || field.getName().toLowerCase().equals("context")) {
        } else {

            if (tipo.equals("STRING")) {
                retorno = cursor.getString(cursor.getColumnIndex(field.getName().toLowerCase()));
            } else if (tipo.equals("LONG")) {
                retorno = cursor.getLong(cursor.getColumnIndex(field.getName().toLowerCase()));
            } else if (tipo.equals("DOUBLE")) {
                retorno = cursor.getDouble(cursor.getColumnIndex(field.getName().toLowerCase()));
            } else if (tipo.equals("BOOLEAN")) {
                retorno = cursor.getInt(cursor.getColumnIndex(field.getName().toLowerCase())) == 0;
            }
            object = insereField(field, object, retorno);
        }
        return object;
    }

    public Object retornaValorCampo(Field field, Object obj) {
        try {
//            String primeiro = field.getName().substring(0, 1);
//            String nomeCampo = field.getName().substring(1, field.getName().length());
////            Object obj1;
////            obj1 = obj;
            Method method = obj.getClass().getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1), null);
            Object object = method.invoke(obj, null);

            return object;
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return field;
    }
}
