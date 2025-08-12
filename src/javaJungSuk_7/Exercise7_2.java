package javaJungSuk_7;

class SutdaDeck {
    final int CARD_NUM =20;
    SutdaCard[] cards = new SutdaCard[CARD_NUM];

    SutdaDeck() {
        for(int i=0;i<CARD_NUM;i++){
            if(i==0){
                cards[i] = new SutdaCard();
            }
            else if(i==2||i==7){
                cards[i] = new SutdaCard(i+1, true);
            }
            else if(i>9){
                cards[i] = new SutdaCard(i-9, false);
            }
            else{
                cards[i] = new SutdaCard(i+1, false);
            }
        }
    }
    void shuffle() {
        for(int i = 0;i<CARD_NUM;i++){
            int j = (int)(Math.random()*CARD_NUM);
            SutdaCard temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    SutdaCard pick(int index){
        return cards[index];
    }

    SutdaCard pick(){
        return pick((int)(Math.random()*CARD_NUM));
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    // info() 대신 Object 클래스의 toString()을 오버라이딩했따.
    public String toString() {
        return num + (isKwang ? "K" : "");
    }
}

public class Exercise7_2 {
    public static void main(String[] args) {
        // Exercise7_1
        SutdaDeck deck = new SutdaDeck();

        for(int i =0;i<deck.cards.length;i++)
            System.out.print(deck.cards[i]+",");
        System.out.println();
        // Exercise7-2
        System.out.println(deck.pick(0));
        System.out.println(deck.pick());
        deck.shuffle();

        for(int i=0;i<deck.cards.length;i++){
            System.out.print(deck.cards[i]+",");
        }
        System.out.println();
        System.out.println(deck.pick(0));
    }
}
