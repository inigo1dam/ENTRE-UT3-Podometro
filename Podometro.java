/**
 * La clase modela un sencillo podómetro que registra información
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * Iñigo Camarero
 * 1.0
 */
public class Podometro {
    private String marca;
    private char sexo;
    private int pasos;
    private double distancia;
    private double altura;
    private double longitudZancada;
    private double totalPasosLaborables;
    private double totalPasosSabado;
    private double totalPasosDomingo;
    private double totalDistanciaSemana;
    private double totalDistanciaFinSemana;
    private int tiempo;
    private int caminatasNoche;
    private double ZANCADA_HOMBRE;
    private double ZANCADA_MUJER;
    /**
     * Inicializa el podómetro con la marca indicada por el parámetro.
     * El resto de atributos se ponen a 0 y el sexo, por defecto, es mujer
     */
    public Podometro(String queMarca) {
        marca = queMarca;
        sexo = 'M';
        pasos =0;
        distancia =0;
        altura =0;
        caminatasNoche = 0;
        tiempo = 0;
        totalDistanciaFinSemana = 0;
        totalDistanciaSemana = 0;
        totalPasosDomingo = 0;
        totalPasosSabado = 0;
        totalPasosLaborables = 0;
        longitudZancada = 0;
        ZANCADA_HOMBRE = 0.45;
        ZANCADA_MUJER = 0.41;
    }

    /**
     * accesor para la marca
     *  
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Simula la configuración del podómetro.
     * Recibe como parámetros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna además el valor adecuado al atributo longitudZancada
     * 
     * (leer enunciado)
     *  
     */
    public void configurar(double queAltura, char queSexo) {
        altura = queAltura;
        sexo = queSexo;
        if (sexo == 'H') { 
            longitudZancada = Math.ceil(altura * ZANCADA_HOMBRE);
        }
        else if (sexo == 'M') { 
            longitudZancada = Math.floor(altura * ZANCADA_MUJER);
        }
    }

    /**
     *  Recibe cuatro parámetros que supondremos correctos:
     *    pasos - el nº de pasos caminados
     *    dia - nº de día de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - Sábado, 7 - Domingo)
     *    horaInicio – hora de inicio de la caminata
     *    horaFin – hora de fin de la caminata
     *    
     *    A partir de estos parámetros el método debe realizar ciertos cálculos
     *    y  actualizará el podómetro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */

    /**
     * Muestra en pantalla la configuración del podómetro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println("Configuración del podómetro");
        System.out.println("***************************");
        System.out.println("");
        System.out.println("Altura" + altura + " " + "cms");
        System.out.println("Sexo" + sexo);
        System.out.println("LongitudZancada" + longitudZancada + " " + "cm");
    }

    /**
     * Muestra en pantalla información acerca de la distancia recorrida,
     * pasos, tiempo total caminado, ....
     * 
     * (leer enunciado)
     *  
     */
    public void registrarCaminata(int pasos, int dia, int horaInicio,
    int horaFin) {
        tiempo = horaFin - horaInicio;
        double vDistancia = longitudZancada * pasos;
        distancia += vDistancia;
        switch (dia) 

        {
            case 1:
                totalPasosLaborables += pasos;
                totalDistanciaSemana += distancia;
                break;
            case 2: 
                totalPasosLaborables += pasos;
                totalDistanciaSemana += distancia;
                break;
            case 3: 
                totalPasosLaborables += pasos;
                totalDistanciaSemana += distancia;
                break;
            case 4:
                totalPasosLaborables += pasos;
                totalDistanciaSemana += distancia;
                break;
            case 5: 
                totalPasosLaborables += pasos;
                totalDistanciaSemana += distancia;
                break;
            case 6:
                totalPasosSabado += pasos;
                totalDistanciaFinSemana += distancia;
                break;
            case 7:
                totalPasosDomingo += pasos;
                totalDistanciaFinSemana += distancia;
                break;   
        }
        totalDistanciaFinSemana= (totalPasosSabado + totalPasosDomingo) * longitudZancada/100000;
        totalDistanciaSemana= totalPasosLaborables * longitudZancada/100000 + totalDistanciaFinSemana; 
    }

    public void printEstadísticas() {
        int tiempoHoras  = tiempo/60;
        int tiempoMinutos = tiempo  - (tiempoHoras*60);
        System.out.println("Estadisticas");
        System.out.println("**********************");
        System.out.println("");
        System.out.println("Distancia recorrida toda la semana" + totalDistanciaSemana +" "+ " Km");
        System.out.println("Distancia recorrida fin de semana" + totalDistanciaFinSemana +  " " + " Km");
        System.out.println("");
        System.out.println("");
        System.out.println("Nº pasos días laborables" +" "+ totalPasosLaborables);
        System.out.println("Nº pasos SÁBADO" +" "+ totalPasosSabado);
        System.out.println("Nº pasos DOMINGO" +" "+ totalPasosDomingo);
        System.out.println(""); 
        System.out.println("");
        System.out.println("Nº caminatas realizadas a partir de las 21h.");
        System.out.println("");
        System.out.println("");
        System.out.println("Tiempo total caminado en la semana."+ tiempoHoras + "h"+"y"+ tiempoMinutos + "m");
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del día
     *  en el que se ha caminado más pasos - "SÁBADO"   "DOMINGO" o  "LABORABLES"
     */
    public String diaMayorNumeroPasos() {
        String dia = "";
        if(totalPasosSabado>totalPasosDomingo && totalPasosSabado>totalPasosLaborables){
            dia ="LABORABLES";
        }
        else if(totalPasosSabado<totalPasosDomingo && totalPasosDomingo>totalPasosLaborables){
            dia ="SABADO";
        }
        else if(totalPasosLaborables<totalPasosDomingo && totalPasosSabado<totalPasosDomingo){
            dia ="DOMINGO";
        }
        else if(totalPasosLaborables==totalPasosDomingo && totalPasosSabado<totalPasosLaborables){
            dia ="LABORABLES DOMINGO";
        }
        else if(totalPasosLaborables==totalPasosSabado && totalPasosSabado<totalPasosDomingo){
            dia ="LABORABLES SABADO";
        }
        else if(totalPasosLaborables==totalPasosSabado && totalPasosLaborables==totalPasosDomingo){
            dia ="LABORABLES SABADO DOMINGO";
        }
        return dia;
    }

    /**
     * Restablecer los valores iniciales del podómetro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no varía
     *  
     */    
    public void reset() {
        sexo = 'M';
        pasos =0;
        distancia =0;
        altura =0;
        caminatasNoche = 0;
        tiempo = 0;
        totalDistanciaFinSemana = 0;
        totalDistanciaSemana = 0;
        totalPasosDomingo = 0;
        totalPasosSabado = 0;
        totalPasosLaborables = 0;
        longitudZancada = 0;
        ZANCADA_HOMBRE = 0;
        ZANCADA_MUJER = 0;
    }
}