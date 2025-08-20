package ejemploconexionjdbc;

import java.time.LocalDate;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private LocalDate fechaNacimiento;
    private LocalDate fechaVentaCliente;

    public Cliente(int idCliente, String nombreCliente, LocalDate fechaNacimiento, LocalDate fechaVentaCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaVentaCliente = fechaVentaCliente;
    }

    public Cliente(String nombreCliente, LocalDate fechaNacimiento, LocalDate fechaVentaCliente) {
        this.nombreCliente = nombreCliente;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaVentaCliente = fechaVentaCliente;
    }

    public int getIdCliente() { return idCliente; }
    public String getNombreCliente() { return nombreCliente; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public LocalDate getFechaVentaCliente() { return fechaVentaCliente; }

    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setFechaVentaCliente(LocalDate fechaVentaCliente) { this.fechaVentaCliente = fechaVentaCliente; }
}
