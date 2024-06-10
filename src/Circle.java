public class Circle implements Findable{

    public static final double pI = 3.14159;

    private String name;
    private Point centralPoint;
    private double radius;

    Circle(String name,Point centralPoint,double radius){
        setName(name);
        setCentralPoint(centralPoint);
        setRadius(radius);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCentralPoint(Point centralPoint){
        this.centralPoint = centralPoint;
    }

    public Point getCentralPoint(){
        return centralPoint;
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

    public boolean sharePoints(Circle circle){
        return !(getRadius() + circle.getRadius() < centralPoint.calculateDistanceBeetweenPoints(circle.getCentralPoint()));
    }

    @Override
    public String toString(){
        return getName()+" = "+"["+ getCentralPoint().getX() +";"+getCentralPoint().getY()+"]" + " Raio = "+getRadius();
    }

    @Override
    public boolean isSimilar(String parameter,String value){

        if(parameter.equals("nome")){
            if(getName().equals(value)){
                return true;
            }
        }
        if(parameter.equals("x")){
            if(getCentralPoint().getX() == Double.parseDouble(value)){
                return true;
            }
        }
        if(parameter.equals("y")){
            if(getCentralPoint().getY() == Double.parseDouble(value)){
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
