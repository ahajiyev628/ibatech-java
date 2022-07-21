package lesson7;

import java.util.Arrays;

public class Box {

    int a, b, h;

    public Box(int a, int b, int h){
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public boolean compare(Box box){
        this.rotate();
        box.rotate();
        return this.a < box.a && this.b < box.b && this.h < box.h;
    }


    public void rotate(){
        int[] params = new int[]{this.a, this.b, this.h};
        Arrays.sort(params);
        this.a = params[0];
        this.b = params[1];
        this.h = params[2];
    }

}
