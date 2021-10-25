/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import hibernate.HibernateUtil;
import hibernate.LineasDeVenta;


//Agregar linea de venta
public class LineaVentaDAO {
    public void addLineaVenta(LineasDeVenta linea){
         SessionFactory sesFact = HibernateUtil.getSessionFactory();
         Session ses = sesFact.openSession();
         Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           ses.save(linea);
           ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }                       
    }
    
    //Eliminar linea de venta
    public void deleteLineaVenta(Integer idLinea){
         SessionFactory sesFact = HibernateUtil.getSessionFactory();
         Session ses = sesFact.openSession();
         Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           LineasDeVenta linea = (LineasDeVenta) ses.get(LineasDeVenta.class,idLinea);
           ses.delete(linea);
           ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }                    
    
    }
    
    
    //Actualizar linea de venta
        public void updateLineasVenta(LineasDeVenta linea){
         SessionFactory sesFact = HibernateUtil.getSessionFactory();
         Session ses = sesFact.openSession();
         Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           
           ses.update(linea);
           ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }          
    }
        
        
        //Encontrar linea de venta
            public LineasDeVenta getLineasVentaID(Integer idLinea){

        LineasDeVenta linea = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           String queryString = "from LineasDeVenta where id_linea = :idFind";
           Query query = ses.createQuery(queryString);
           query.setParameter("idFind", idLinea);
           linea = (LineasDeVenta) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.flush();

            ses.close();
        }            
        
        return linea;
    }
            
    //Obtencion de datos de linea de venta   
    public List<LineasDeVenta> obtenerLinea(){
        List<LineasDeVenta> linea = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           String queryString = "from LineasDeVenta";
           Query query = ses.createQuery(queryString);
           linea= query.list();          
           
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.flush();
            ses.close();
        }                  
        return linea;
    }    



}
