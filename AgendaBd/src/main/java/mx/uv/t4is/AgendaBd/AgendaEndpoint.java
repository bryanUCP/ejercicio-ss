package mx.uv.t4is.AgendaBd;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.agenda.EventosResponse;
import https.t4is_uv_mx.agenda.AgendarEventoRequest;
import https.t4is_uv_mx.agenda.AgendarEventoResponse;

import https.t4is_uv_mx.agenda.EliminarEventoRequest;
import https.t4is_uv_mx.agenda.EliminarEventoResponse;

import https.t4is_uv_mx.agenda.ModificarEventoRequest;
import https.t4is_uv_mx.agenda.ModificarEventoResponse;

@Endpoint
public class AgendaEndpoint {

    //int contadorId = 1 ;
    //List<Agenda> eventos = new ArrayList<>();

    @Autowired
    Iagenda iagenda;

    //--------------------------------------------------------------------------------------------------------
    /*En esta parte recibimos los datos del xsd para la accion de registrar, los guardamos en la base de datos y despues los mostramos en pantalla
    con la parte del response*/

    @PayloadRoot(localPart = "AgendarEventoRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public AgendarEventoResponse evento(@RequestPayload AgendarEventoRequest peticion) {
        AgendarEventoResponse respuesta = new AgendarEventoResponse();
        respuesta.setRNombre(peticion.getNombre());
        respuesta.setRFInicio(peticion.getFInicio());
        respuesta.setRFLimite(peticion.getFLimite());
        respuesta.setRDescripcion(peticion.getDescripcion());
        Agenda agenda = new Agenda();
        agenda.setNombre(peticion.getNombre());
        agenda.setFInicio(peticion.getFInicio());
        agenda.setFLimite(peticion.getFLimite());
        agenda.setDescripcion(peticion.getDescripcion());
        //agenda.setId(contadorId);
        //eventos.add(agenda);
        //contadorId ++;
        iagenda.save(agenda);
        return respuesta;
    }

    //------------------------------------------------------------------------

    /* En esta parte no recibimos nada del xsd pero mostramos los datos de los eventos registrados en la base de datos
    en pantalla con EventosResponse*/

    @PayloadRoot(localPart = "EventosRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public EventosResponse Eventos(){
        EventosResponse respuesta = new EventosResponse();
        Iterable<Agenda> lista = iagenda.findAll();
        for (Agenda agenda : lista) {
            EventosResponse.AgendaBD EventosBuscar = new EventosResponse.AgendaBD();
            EventosBuscar.setId(agenda.getId());
            EventosBuscar.setNombre(agenda.getNombre());
            EventosBuscar.setFInicio(agenda.getFInicio());
            EventosBuscar.setFLimite(agenda.getFLimite());
            EventosBuscar.setDescripcion(agenda.getDescripcion());
            respuesta.getAgendaBD().add(EventosBuscar);
        }
        return respuesta;
    }

    //------------------------------------------------------------------------

    /*En esta parte hacemos la accion de modificar eventos, introducimos el id del evento que queremos modificar y tambien los datos nuevos,
    se guardan los datos en la base de datos y despues se muestran con el ModificarEventoResponse*/

    @PayloadRoot(localPart = "ModificarEventoRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public ModificarEventoResponse modificarSaludo(@RequestPayload ModificarEventoRequest peticion){
        ModificarEventoResponse respuesta = new ModificarEventoResponse();

        Agenda agenda = new Agenda();

        /*if(!eventos.isEmpty()){ 
            for (Agenda EventoModificar : eventos) { 
                if(EventoModificar.getId() == peticion.getId()){ 
                    EventoModificar.setFLimite(peticion.getNuevaFLimite()); 
                    respuesta.setId(peticion.getId()); 
                    respuesta.setFLimite(peticion.getNuevaFLimite());
                }
            }
        }*/

        agenda.setId(peticion.getId());
        agenda.setNombre(peticion.getNuevoNombre());
        agenda.setFInicio(peticion.getNuevaFInicio());
        agenda.setFLimite(peticion.getNuevaFLimite());
        agenda.setDescripcion(peticion.getNuevaDescripcion());
        iagenda.save(agenda);
        respuesta.setId(peticion.getId());
        respuesta.setNombre(peticion.getNuevoNombre());
        respuesta.setFInicio(peticion.getNuevaFInicio());
        respuesta.setFLimite(peticion.getNuevaFLimite());
        respuesta.setDescripcion(peticion.getNuevaDescripcion());


        return respuesta;
    }

    //-----------------------------------------------------------------------------

    /*En esta parte modificamos un evento mediante su id, introducimos el id del evento a eliminar en el Request, lo borra en la base de datos y
    despues mostramos la lista de eventos de la base pero ya actualizada con el evento ya borrado. eso se muestra con el Response*/

    @PayloadRoot(localPart = "EliminarEventoRequest", namespace = "https://t4is.uv.mx/agenda")
    @ResponsePayload
    public EliminarEventoResponse borrarEvento(@RequestPayload EliminarEventoRequest peticion){
        //int indexDelElementoABorrar = 0;
        //boolean elementoEncontrado = false;
        EliminarEventoResponse respuesta = new EliminarEventoResponse();
        respuesta.getAgenda().clear(); 
        /*if(!eventos.isEmpty()){
            for (Agenda EventoBorrar : eventos) {
                if(EventoBorrar.getId() == peticion.getId()){
                    indexDelElementoABorrar = eventos.indexOf(EventoBorrar);
                    elementoEncontrado = true;
                   
                }
            }
            if (elementoEncontrado){
                eventos.remove(indexDelElementoABorrar);
            }
            for (Agenda agenda : eventos) {
                EliminarEventoResponse.Agenda EventoNoEliminado = new EliminarEventoResponse.Agenda();
                EventoNoEliminado.setId(agenda.getId());
                EventoNoEliminado.setNombre(agenda.getNombre());
                EventoNoEliminado.setFInicio(agenda.getFInicio());
                EventoNoEliminado.setFLimite(agenda.getFLimite());
                EventoNoEliminado.setDescripcion(agenda.getDescripcion());
                respuesta.getAgenda().add(EventoNoEliminado);
            }
        }*/

        //Eliminar datos en la base de datos de la tabla agenda
        iagenda.deleteById(peticion.getId());

        Iterable<Agenda> lista = iagenda.findAll();
        for (Agenda agenda : lista) {
            EliminarEventoResponse.Agenda EventoEliminar = new EliminarEventoResponse.Agenda();
            EventoEliminar.setId(agenda.getId());
            EventoEliminar.setNombre(agenda.getNombre());
            EventoEliminar.setFInicio(agenda.getFInicio());
            EventoEliminar.setFLimite(agenda.getFLimite());
            EventoEliminar.setDescripcion(agenda.getDescripcion());
            respuesta.getAgenda().add(EventoEliminar);
        }

        return respuesta;

    }

    
}