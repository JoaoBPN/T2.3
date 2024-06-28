package Models;

public class Circle implements Findable {

    public static final double pI = 3.14159;

    private String name;
    private Dot centralDot;
    private double radius;

    public Circle(String name, Dot centralDot, double radius){
        setName(name);
        setCentralDot(centralDot);
        setRadius(radius);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCentralDot(Dot centralDot){
        this.centralDot = centralDot;
    }

    public Dot getCentralDot(){
        return centralDot;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    public double getRadius(){
        return radius;
    }

    public double getDiameter(){
        return 2 * getRadius();
    }

    public double getArea(){
        return pI * getRadius() * getRadius();
    }

    public double getCircumference(){
        return 2 * pI * getRadius();
    }

    public boolean shareDots(Circle circle){
        return !(getRadius() + circle.getRadius() < centralDot.distanceBeetweenDots(circle.getCentralDot()));
    }

    @Override
    public String toString(){
        return getName()+" = "+"["+ getCentralDot().getX() +";"+ getCentralDot().getY()+"]" + " Raio = "+getRadius();
    }

    @Override
    public String[] ownMethods(String[] parts){
        int maxParameterAmmout = 4;
        String[] methods = new String[maxParameterAmmout];
        for(int i = 0;i < parts.length;i+=2){
            switch (parts[i].toLowerCase()) {
                case "nome" -> methods[0] = parts[i] + " " + parts[i + 1];
                case "x" -> methods[1] = parts[i] + " " + parts[i + 1];
                case "y" -> methods[2] = parts[i] + " " + parts[i + 1];
                case "raio" -> methods[3] = parts[i] + " " +parts[i + 1];
                default -> {
                    return null;
                }
            }
        }
        return methods;
    }

    @Override
    public boolean hasSameParameter(String parameter, String value){

        if(parameter.equals("nome")){
            if(getName().equals(value)){
                return true;
            }
        }
        if(parameter.equals("x")){
            if(getCentralDot().getX() == Double.parseDouble(value)){
                return true;
            }
        }
        if(parameter.equals("y")){
            if(getCentralDot().getY() == Double.parseDouble(value)){
                return true;
            }
        }
        if(parameter.equals("raio")){
            if(getRadius() == Double.parseDouble(value)){
                return true;
            }
        }
        return false;
    }

}
