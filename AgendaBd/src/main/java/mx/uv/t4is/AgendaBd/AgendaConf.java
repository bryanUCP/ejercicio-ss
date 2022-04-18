package mx.uv.t4is.AgendaBd;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;

@EnableWs
@Configuration
public class AgendaConf {
    @Bean /*los @ son anotaciones. EL bean son objetos que vamos usar para la Web */
    public XsdSchema eventosSchema(){
        return new SimpleXsdSchema(new ClassPathResource("agenda.xsd"));
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }
 
    @Bean(name = "agenda")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema eventosSchema) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("agendaPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("https://t4is.uv.mx/agenda");
        wsdl.setSchema(eventosSchema);
        return wsdl;
    }
    
}
