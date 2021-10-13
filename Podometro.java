/**
 * La clase modela un sencillo pod�metro que registra informaci�n
 * acerca de los pasos, distancia, ..... que una persona
 * ha dado en una semana. 
 * 
 * I�igo Camarero
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
     * Inicializa el pod�metro con la marca indicada por el par�metro.
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
     * Simula la configuraci�n del pod�metro.
     * Recibe como par�metros la altura y el sexo de una persona
     * y asigna estos valores a los atributos correspondiente.
     * Asigna adem�s el valor adecuado al atributo longitudZancada
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
     *  Recibe cuatro par�metros que supondremos correctos:
     *    pasos - el n� de pasos caminados
     *    dia - n� de d�a de la semana en que se ha hecho la caminata 
     *              (1 - Lunes, 2 - Martes - .... - 6 - S�bado, 7 - Domingo)
     *    horaInicio � hora de inicio de la caminata
     *    horaFin � hora de fin de la caminata
     *    
     *    A partir de estos par�metros el m�todo debe realizar ciertos c�lculos
     *    y  actualizar� el pod�metro adecuadamente  
     *   
     *   (leer enunciado del ejercicio)
     */

    /**
     * Muestra en pantalla la configuraci�n del pod�metro
     * (altura, sexo y longitud de la zancada)
     * 
     * (ver enunciado)
     *  
     */
    public void printConfiguracion() {
        System.out.println("Configuraci�n del pod�metro");
        System.out.println("***************************");
        System.out.println("");
        System.out.println("Altura" + altura + " " + "cms");
        System.out.println("Sexo" + sexo);
        System.out.println("LongitudZancada" + longitudZancada + " " + "cm");
    }

    /**
     * Muestra en pantalla informaci�n acerca de la distancia recorrida,
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

    public void printEstad�sticas() {
        int tiempoHoras  = tiempo/60;
        int tiempoMinutos = tiempo  - (tiempoHoras*60);
        System.out.println("Estadisticas");
        System.out.println("**********************");
        System.out.println("");
        System.out.println("Distancia recorrida toda la semana" + totalDistanciaSemana +" "+ " Km");
        System.out.println("Distancia recorrida fin de semana" + totalDistanciaFinSemana +  " " + " Km");
        System.out.println("");
        System.out.println("");
        System.out.println("N� pasos d�as laborables" +" "+ totalPasosLaborables);
        System.out.println("N� pasos S�BADO" +" "+ totalPasosSabado);
        System.out.println("N� pasos DOMINGO" +" "+ totalPasosDomingo);
        System.out.println(""); 
        System.out.println("");
        System.out.println("N� caminatas realizadas a partir de las 21h.");
        System.out.println("");
        System.out.println("");
        System.out.println("Tiempo total caminado en la semana."+ tiempoHoras + "h"+"y"+ tiempoMinutos + "m");
    }

    /**
     *  Calcula y devuelve un String que representa el nombre del d�a
     *  en el que se ha caminado m�s pasos - "S�BADO"   "DOMINGO" o  "LABORABLES"
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
     * Restablecer los valores iniciales del pod�metro
     * Todos los atributos se ponen a cero salvo el sexo
     * que se establece a MUJER. La marca no var�a
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