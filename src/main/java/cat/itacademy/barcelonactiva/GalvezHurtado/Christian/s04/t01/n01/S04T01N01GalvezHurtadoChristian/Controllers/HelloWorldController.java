package cat.itacademy.barcelonactiva.GalvezHurtado.Christian.s04.t01.n01.S04T01N01GalvezHurtadoChristian.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(defaultValue = "UNKNOWN")  String name){//Definimos que si es llamado con la recepción de un nombre lo recibirá, de no ser así name = UNKNOW
        return "Hello, " + name + ". You are running a Maven project";
    }

    //http://localhost:9000/HelloWorld -> Imprimirá el método llamado /HelloWorld sin enviar parámetros
    //http://localhost:9000/HelloWorld?name=nombre -> Imprimirá el método /HelloWorld pero recibiendo "name=nombre"

    @GetMapping(value = {"/HelloWorld2","/HelloWorld2/{name}"})
    public String Saluda2(@PathVariable(required = false)String name){
        if(name == null) {
            name = "UNKNOWN";
        }
        return "Hello, " + name + ". You are running a Maven project";
    }
}
