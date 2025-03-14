package Ex01_RestAssuredBasics;

public class Ex03_BuilderPatteren {
    public Ex03_BuilderPatteren Step1()
    {
        System.out.println("Step 1");
          return this;
    }
    public Ex03_BuilderPatteren Step2()
    {
        System.out.println("Step 2");
        return this;
    }
    public Ex03_BuilderPatteren Step3()
    {
        System.out.println("Step 3");
        return this;
    }

    public static void main(String[] args) {
        Ex03_BuilderPatteren bp=new Ex03_BuilderPatteren();
        bp.Step1().Step2().Step3();
    }
}
