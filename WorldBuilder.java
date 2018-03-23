import java.io.*;
import java.util.Scanner;

public class WorldBuilder {
    private final Asisten asisten1,asisten2;
    private final Praktikan praktikan1, praktikan2, praktikan3, praktikan4;
    private Question[] questionList;

    //constructor using builder design pattern
    private WorldBuilder(Builder builder){
        this.asisten1 = builder.asisten1;
        this.asisten2 = builder.asisten2;
        this.praktikan1 = builder.praktikan1;
        this.praktikan2 = builder.praktikan2;
        this.praktikan3 = builder.praktikan3;
        this.praktikan4 = builder.praktikan4;
        this.questionList = builder.questionList;
    }
    //Getter method
    /**
     * @return the asisten1
     */
    public Asisten getAsisten1() {
        return asisten1;
    }
    /**
     * @return the asisten2
     */
    public Asisten getAsisten2() {
        return asisten2;
    }
    /**
     * @return the praktikan1
     */
    public Praktikan getPraktikan1() {
        return praktikan1;
    }
    /**
     * @return the praktikan2
     */
    public Praktikan getPraktikan2() {
        return praktikan2;
    }
    /**
     * @return the praktikan3
     */
    public Praktikan getPraktikan3() {
        return praktikan3;
    }
    /**
     * @return the praktikan4
     */
    public Praktikan getPraktikan4() {
        return praktikan4;
    }
    /**
     * @return the questionList
     */
    public Question[] getQuestionList() {
        return questionList;
    }
    //Another getter
    public Question getQuestion(int i){
        return questionList[i];
    }
    //static inner class builder
    public static class Builder{
        private Asisten asisten1, asisten2;
        private Praktikan praktikan1, praktikan2, praktikan3, praktikan4;
        private Question[] questionList;

        //method builder
        public Builder asisten1(final Asisten asisten1){
            this.asisten1 = asisten1;
            return this;
        } 
        public Builder asisten2(final Asisten asisten2){
            this.asisten2 = asisten2;
            return this;
        }
        public Builder praktikan1(final Praktikan praktikan1){
            this.praktikan1 = praktikan1;
            return this;
        }
        public Builder praktikan2(final Praktikan praktikan2){
            this.praktikan2 = praktikan2;
            return this;
        }
        
        public Builder praktikan3(final Praktikan praktikan3) {
            this.praktikan3 = praktikan3;
            return this;
        }
        
        public Builder praktikan4(final Praktikan praktikan4) {
            this.praktikan4 = praktikan4;
            return this;
        }

        public Builder questionList(final Question[] questionList){
            this.questionList = questionList;
            return this;
        }

        public WorldBuilder build(){
            return new WorldBuilder(this);
        }
    }


}
