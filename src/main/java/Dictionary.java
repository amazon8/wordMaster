public class Dictionary {

    int difficulty;
    String word;
    String meaning;

    public Dictionary(int _difficulty, String _word, String _meaning)
    {
        difficulty = _difficulty;
        word = _word;
        meaning = _meaning;

    }

    public int getDifficulty() {
        return difficulty;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
