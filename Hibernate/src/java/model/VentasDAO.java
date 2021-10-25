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
import hibernate.Ventas;


public class VentasDAO {
    //INGRESO DE VENTAS
    public void addVenta(Ventas ventas){
         SessionFactory sesFact = HibernateUtil.getSessionFactory();
         Session ses = sesFact.openSession();
         Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           ses.save(ventas);
           ses.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            //ses.flush();
            //ses.close();
        }                       
    }
    
     //Delete de adatos de venta
    public void deleteVenta(Integer idVenta){
         SessionFactory sesFact = HibernateUtil.getSessionFactory();
         Session ses = sesFact.openSession();
         Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           Ventas venta = (Ventas) ses.get(Ventas.class,idVenta);
           ses.delete(venta);
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
    
    
     //Actualizacion de adatos de venta
    
        public void updateVenta(Ventas venta){
         SessionFactory sesFact = HibernateUtil.getSessionFactory();
         Session ses = sesFact.openSession();
         Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           
           ses.update(venta);
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
        
     //Busqueda de datos
        
            public Ventas getVentaID(Integer idVenta){

        Ventas venta = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           String queryString = "from Ventas where id_venta = :idFind";
           Query query = ses.createQuery(queryString);
           query.setParameter("idFind", idVenta);
           venta = (Ventas) query.uniqueResult();
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            ses.flush();

            ses.close();
        }            
        
        return venta;
    }
       
   
//Obtencion y recorrido de datos      
            
    public List<Ventas> obtenerVentas(){
        List<Ventas> ventas = null;
        SessionFactory sesFact = HibernateUtil.getSessionFactory();
        Session ses = sesFact.openSession();
        Transaction tra = null;
 
        try {
           tra=ses.beginTransaction();
           String queryString = "from Ventas";
           Query query = ses.createQuery(queryString);
           ventas= query.list();          
           
        } catch (HibernateException e) {
            e.printStackTrace();
            if ( tra != null ){
                tra.rollback();
            }
        }finally{
            //ses.flush();
            //  ses.close();
        }                  
        return ventas;
    }    



}
