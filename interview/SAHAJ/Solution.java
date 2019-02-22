package interview.SAHAJ;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the path of file ::");
        String filePath = input.nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String paragraph = reader.readLine();
        ArrayList<String> questions = new ArrayList<>();

        for(int i = 0; i < 5; i++)
            questions.add(reader.readLine());

        String answersLine = reader.readLine();
        String[] ans = answersLine.split(";");
        ArrayList<String> answers = new ArrayList<>();
        Collections.addAll(answers, ans);

        String[] results = getResult(paragraph, questions, answers);
        for(String r : results)
            System.out.println(r);
    }

    private static String[] getResult(String paragraph, ArrayList<String> questions, ArrayList<String> answers){
        String[] result = new String[questions.size()];
        String[] sentences = paragraph.split("[.]");
        ArrayList<String> sentencesContainingAnswer = new ArrayList<>();
        for (String sentence : sentences) {
            for (String answer : answers)
                if (sentence.toLowerCase().contains(answer.toLowerCase())) {
                    sentencesContainingAnswer.add(sentence.toLowerCase());
                    break;
                }
        }
        String[] keywordsInQuestion;
        String temp;
        for(int i = 0; i < questions.size(); i++){
            keywordsInQuestion = findKeywords(questions.get(i));
            int index = findBestMatch(sentencesContainingAnswer, keywordsInQuestion);
            temp = " ";
            for(String answer : answers){
                if(sentencesContainingAnswer.get(index).contains(answer.toLowerCase()) && answer.length() > temp.length())
                    temp = answer;
            }

            result[i] = temp;
        }

        return result;
    }
   private static int findBestMatch(ArrayList<String> sentencesContainingAnswer, String[] keywordsInQuestion){
        int max = 0, index = 0, temp;
        for(int i = 0; i < sentencesContainingAnswer.size(); i++){
            temp = 0;
            for (String keyword : keywordsInQuestion) {
                if (sentencesContainingAnswer.get(i).contains(keyword)) {
                    if (keyword.contains("\""))
                        temp += 2;
                    temp++;
                }
            }

            if(temp > max){
                max = temp;
                index = i;
            }
        }
        return index;
    }

    private static String[] findKeywords(String question){
        if(question == null )
            return null;
        boolean found;

        String[] wordsInQuestion = question.split(" ");
        ArrayList<String> keywords = new ArrayList<>();
        String[] commonWords = {"which", "what", "where", "who", "when", "is", "are", "was", "were", "have", "had", "do", "did", "how", "why", "will", "shall", "the", ".", "?", "a"};

        for(String keyword : wordsInQuestion){
            keyword = keyword.replace("?", "");
            found = false;
            for(String commonWord : commonWords)
                if(commonWord.equalsIgnoreCase(keyword)){
                    found = true;
                    break;
                }
            if(found)
                continue;

            if(keyword.endsWith("ed"))
                keyword = keyword.substring(0, keyword.length() - 2);

            if(keyword.endsWith("s"))
                keyword = keyword.substring(0, keyword.length() - 1);

            keywords.add(keyword.toLowerCase());

        }

        return keywords.toArray(new String[0]);
    }


}