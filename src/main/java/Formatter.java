public class Formatter {
    public String getPhraseEnd(double dividedSum) {
        return switch ((int) dividedSum % 10) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
    }
}
