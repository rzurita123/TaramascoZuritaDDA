package logica;

public class Sesion {
    private Usuario usuario;

    public Sesion(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    @Override
    public String toString(){
    return usuario.getNombreCompleto();
    }
}

