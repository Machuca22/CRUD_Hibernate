/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import hibernate.LineasDeVenta;
import model.LineaVentaDAO;

/**
 *
 * @author mauricio
 */
@ManagedBean
@SessionScoped
public class LineaBean {
private LineasDeVenta linea;
    /**
     * Creates a new instance of LineaBean
     */
    public LineaBean() {
        linea= new LineasDeVenta();
    }
           public List<LineasDeVenta> getLineaDeVenta(){
        LineaVentaDAO lineaDao = new LineaVentaDAO();
        List<LineasDeVenta> lista = lineaDao.obtenerLinea();
        return lista;
    }
           
           
             public void addLinea( ){
        LineaVentaDAO lineaDao = new LineaVentaDAO();
       
        lineaDao.addLineaVenta(getLineasDeVenta());
        
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Linea de Venta con ID " + this.linea.getIdLinea() + " Agregado" ));
        
        this.linea = new LineasDeVenta();
    }
    
        public void returnLineaId(){
        LineaVentaDAO lineaDao = new LineaVentaDAO();
        LineasDeVenta tmp = lineaDao.getLineasVentaID(this.linea.getIdLinea());
        
        this.linea = tmp;
        if(linea == null){
            FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Linea NO especificado"));
            
            this.linea = new LineasDeVenta();
        }
      
    }
        
        public String deleteLinea(){
      LineaVentaDAO lineaDao = new LineaVentaDAO();
        LineasDeVenta obtlinea= lineaDao.getLineasVentaID(this.linea.getIdLinea());
       
       if(obtlinea != null){
       lineaDao.deleteLineaVenta(this.linea.getIdLinea());
       
       FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Linea de Venta con ID " + this.linea.getIdLinea() + " Eliminado" ));
       
       }else{
            FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Linea de Venta con ID " + this.linea.getIdLinea() + " NO encontrado" ));
       }
        
       this.linea = new LineasDeVenta();
       return "LineaVenta"; 
        
    }
        
          public String updateLineaVenta(){
        LineaVentaDAO lineaDao = new LineaVentaDAO();
        LineasDeVenta obtlinea= lineaDao.getLineasVentaID(this.linea.getIdLinea());
       
       if(obtlinea != null){
            
            lineaDao.updateLineasVenta(this.linea);
            FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Linea de Venta con ID " + this.linea.getIdLinea() + " Actualizado" ));
           
       }else{
           
           FacesContext.getCurrentInstance().addMessage(null,
                           new FacesMessage("Linea de Venta con ID " + this.linea.getIdLinea() + " NO encontrado" )); 
       }
        
       this.linea= new LineasDeVenta();
       return "LineaVenta"; 
        
    }
    
     public LineasDeVenta getLineasDeVenta() {
        return linea;
    }
   
    public void setLineasDeVenta(LineasDeVenta linea) {
        this.linea = linea;
    }
  
    
}
