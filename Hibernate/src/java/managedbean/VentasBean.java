/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import hibernate.LineasDeVenta;
import hibernate.Ventas;
import model.VentasDAO;
import hibernate.Ventas;
import model.LineaVentaDAO;



/**
 *
 * @author mauricio
 */
@ManagedBean
@SessionScoped
public class VentasBean {

       private Ventas venta;
        private LineasDeVenta linea;
        
       
       
    public VentasBean() {
                 venta = new Ventas();
    }
    
    public void addVenta( ){
        VentasDAO ventaDao = new VentasDAO();
       
        LineaVentaDAO  lineaDAO = new LineaVentaDAO(); 
        LineasDeVenta liV = new LineasDeVenta();
        liV = lineaDAO.getLineasVentaID(this.venta.getLinea());
        
        Ventas tmp = getVenta();
        tmp.setLineasDeVenta(liV);
        
        ventaDao.addVenta(tmp);
        
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Venta con ID " + this.venta.getIdVenta() + " Agregado" ));
        
        this.venta = new Ventas();
    }
    
        public void returnVentaId(){
        VentasDAO ventaDao = new VentasDAO();
        
        
        
        Ventas tmp = ventaDao.getVentaID(this.venta.getIdVenta()) ;
        
        
        this.venta = tmp;
        if(venta == null){
            FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Venta NO especificado"));
            
            this.venta = new Ventas();
        }
      
    }
        
        public String deleteVenta(){
       VentasDAO ventaDao = new VentasDAO();
       Ventas obtventa = ventaDao.getVentaID(this.venta.getIdVenta());
       
       if(obtventa != null){
       ventaDao.deleteVenta(this.venta.getIdVenta());
       
       FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Venta con ID " + this.venta.getIdVenta() + " Eliminado" ));
       
       }else{
            FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Venta con ID " + this.venta.getIdVenta() + " NO encontrado" ));
       }
        
       this.venta = new Ventas();
       return "Ventas"; 
        
    }
        
             public String updateVenta(){
     VentasDAO ventaDao = new VentasDAO();
       Ventas obtventa = ventaDao.getVentaID(this.venta.getIdVenta());
       
       if(obtventa != null){
            
            ventaDao.updateVenta(this.venta);
            FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Venta con ID " + this.venta.getIdVenta() + " Actualizado" ));
           
       }else{
           
           FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Venta con ID " + this.venta.getIdVenta() + " NO encontrado" )); 
       }
        
       this.venta = new Ventas();
       return "Ventas"; 
        
    }   
             
             public List<Ventas> getVentas(){
        VentasDAO ventaDao = new VentasDAO();
        List<Ventas> lista = ventaDao.obtenerVentas();
        return lista;
    }
    
    
      public Ventas getVenta() {
        return venta;
    }
   
    public void setVenta(Ventas venta) {
        this.venta = venta;
    }
    


      public LineasDeVenta getLineasDeVenta() {
        return linea;
    }
   
    public void setLineasDeVenta(LineasDeVenta linea) {
        this.linea = linea;
    }
  
    
}
