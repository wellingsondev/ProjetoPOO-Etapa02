public interface Agendavel {

    abstract void cancelar();
    abstract String cancelar(String motivo);
    abstract void agendar();
    abstract void remarcar();
    
}
