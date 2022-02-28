package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence) {

        if (isSentenceStartWithCapitalLetter(sentence)) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        if (isSentenceHasCorrectEnding(sentence)) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        if (isSentenceLong(sentence)) {
            return transformSentence(sentence);
        } else {
            return sentence;
        }
    }


    private boolean isSentenceStartWithCapitalLetter(String sentence) {
        char firstLetter = sentence.charAt(0);
        return !(Character.isUpperCase(firstLetter));
    }

    private boolean isSentenceHasCorrectEnding(String sentence) {
        return !(sentence.endsWith(".") || sentence.endsWith("!") || sentence.endsWith("?"));
    }

    private boolean isSentenceLong(String sentence) {
        String[] parts = sentence.split(" ");
        return parts.length >= 5;
    }

    private String transformSentence(String sentence) {
        String[] parts = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(parts[0]).append(" ... ").append(parts[parts.length - 1]);
        return sb.toString();
    }
}
