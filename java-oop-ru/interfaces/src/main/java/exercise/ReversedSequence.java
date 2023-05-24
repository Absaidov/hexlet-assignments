package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    public String word;
    public ReversedSequence (String word){
        this.word = word;
    }
    @Override
    public String toString(){

        word  = new StringBuilder(word).reverse().toString();
        return word;
    }
    @Override
    public int length() {
        return word.length();
    }

    @Override
    public char charAt(int index) {
        return word.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return word.subSequence(start, end);
    }


}
// END
