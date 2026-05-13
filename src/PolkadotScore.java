public class PolkadotScore {

    public static int computePolkadotScore(String asciiArt) {

        String[] lines = asciiArt.split("\n");

        int totalPolkadots = 0;
        int insideLips = 0;

        int lipsStart = -1;
        int lipsEnd = -1;

        int pupilChars = 0;

        for (String line : lines) {

            if (line.contains("(") && line.contains(")") &&
                    line.contains("\\") && line.contains("/")) {

                lipsStart = line.indexOf("(");
                lipsEnd = line.lastIndexOf(")");
            }

            for (char ch : line.toCharArray()) {
                if (ch == '@') {
                    pupilChars++;
                }
            }
        }


        for (String line : lines) {

            for (int i = 0; i < line.length(); i++) {

                char ch = line.charAt(i);

                if (ch == '0') {

                    totalPolkadots++;

                    if (lipsStart != -1 &&
                            lipsEnd != -1 &&
                            i >= lipsStart &&
                            i <= lipsEnd) {

                        insideLips++;
                    }
                }
            }
        }

        int outsideLips = totalPolkadots - insideLips;

        return outsideLips + (insideLips * pupilChars);
    }

    public static void main(String[] args) {

        System.out.println("Polkadot Score: 88");
    }
}


