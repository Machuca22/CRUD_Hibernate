package hibernate;
// Generated Sep 19, 2018 9:07:10 PM by Hibernate Tools 4.3.1


import java.util.Date;


public class Ventas  implements java.io.Serializable {


     private Integer idVenta;
     private LineasDeVenta lineasDeVenta;
     private Date fechaVenta;
     private String descripcion;
     private int linea;

    

    public Ventas() {
    }

    public Ventas(LineasDeVenta lineasDeVenta, Date fechaVenta, String descripcion, String LineasDeVenta) {
       this.lineasDeVenta = lineasDeVenta;
       this.fechaVenta = fechaVenta;
       this.descripcion = descripcion;

    }
   
    public Integer getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public LineasDeVenta getLineasDeVenta() {
        return this.lineasDeVenta;
    }
    
    public void setLineasDeVenta(LineasDeVenta lineasDeVenta) {
        this.lineasDeVenta = lineasDeVenta;
    }
    public Date getFechaVenta() {
        return this.fechaVenta;
    }
    
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the linea
     */
    public int getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(int linea) {
        this.linea = linea;
       
          
    }
    
    
    
    


    



}


