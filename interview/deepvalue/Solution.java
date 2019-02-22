package interview.deepvalue;

import java.io.*;

class treeNode{

    treeNode left;
    String name;
    int weight;
    treeNode right;
    treeNode(String nodeName, int w)
    {
        this.name = nodeName;
        this.weight = w;
        this.left = null;
        this.right = null;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter the path of File");
        String filePath = reader.readLine();
        reader.close();
        InputStream fis = new FileInputStream(filePath);
        reader = new BufferedReader(new InputStreamReader(fis));
        String line;
        String [] treeArray;
        treeNode node = null;
        while ((line = reader.readLine()) != null)
        {
            if (line.startsWith("#"))
            {
                continue;
            }
            treeArray = line.split(",");
            if (node == null){

                node = new treeNode(treeArray[0],1);
                int val=0;
                boolean found = true;
                try{
                    val = Integer.parseInt(treeArray[1]);
                }catch (NumberFormatException nfe){found = false;}
                if (found)
                {
                    node.left = new treeNode(treeArray[1],1);
                }
                else
                {
                    node.left = new treeNode(null,val);
                }
                found = true;
                try{
                    val = Integer.parseInt(treeArray[2]);
                }catch (NumberFormatException nfe){found = false;}
                if (found)
                {
                    node.right = new treeNode(treeArray[2],1);
                }
                else
                {
                    node.right = new treeNode(null,val);
                }
            }
            //node.right = treeArray[2];

        }
        while(node != null)
        {
            System.out.println(node.name+"  "+node.weight);
            node = node.left;
        }
    }
}
