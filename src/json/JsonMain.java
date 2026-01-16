package json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonMain {
    enum ContentType {
        BULLETLIST,
        ITEMLIST,
        PARAGRAPH,
        TEXT
    }
    private static final String delimiter = " -> ";
    private static final String newLine = "\n";

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();

            // Parse the JSON
            Root root = mapper.readValue(new File("final.json"), Root.class);
            List<Content> contents = root.getContent();

//            printAsBullets(contents, 0);
            List<String> results = parserContent(contents, "");
            System.out.println(results);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static List<String> parserContent(List<Content> contents, String path) {
        List<String> results = new ArrayList<>();

        if(contents.isEmpty()) {
            return results;
        }
       /* contents.forEach(content -> {
            if(content.getType().equalsIgnoreCase(ContentType.BULLETLIST.name())) {
                for(Content bulletC : content.getChildren()) {
                    StringBuilder sb = new StringBuilder();
                    if (bulletC.getType().equalsIgnoreCase(ContentType.ITEMLIST.name())) {
                        for(Content listItemC : bulletC.getChildren()) {
                            if (listItemC.getType().equalsIgnoreCase(ContentType.PARAGRAPH.name())) {
                                for(Content paraC : listItemC.getChildren()) {
                                    if (paraC.getType().equalsIgnoreCase(ContentType.TEXT.name())) {
//                                        if(content.getText()!=null){
//                                            sb.append(content.getText()).append(delimiter);
//                                        }
//                                        if(bulletC.getText()!=null){
//                                            sb.append(bulletC.getText()).append(delimiter);
//                                        }
//                                        if(listItemC.getText()!=null){
//                                            sb.append(listItemC.getText()).append(delimiter);
//                                        }
                                        sb.append(paraC.getText());
                                        sb.append(delimiter).append(newLine);
                                        results.add(sb.toString());
                                    }
                                }
                            }
                            if (listItemC.getType().equalsIgnoreCase(ContentType.ITEMLIST.name())) {
                                for(Content paraC : listItemC.getChildren()) {
                                    if (paraC.getType().equalsIgnoreCase(ContentType.TEXT.name())) {
                                        sb.append(paraC.getText());
                                        sb.append(delimiter).append(newLine);
                                        results.add(sb.toString());
                                    }
                                }
                            }

                        }
                    }

                }
            }
        });*/
        for (Content c : contents) {
            String currentPath = path;
            // If this node has text, build a new path
            currentPath = (c.getText() != null)
                    ? (path.isEmpty() ? c.getText() : path + " -> " + c.getText())
                    : path;

            // If leaf node (no children)
            if (c.getChildren() == null || c.getChildren().isEmpty()) {
                System.out.println(currentPath);
            } else {
                // Recurse into children
                parserContent(c.getChildren(), currentPath);
            }
        }
        return results;
    }

    public static void printContent(List<Content> contents, int level) {
        if (contents == null) return;

        for (Content c : contents) {
            // Indent based on level
            String indent = "  ".repeat(level);

            // Print type and text if present
            if (c.getText() != null) {
                System.out.println(indent + "- " + c.getType() + ": " + c.getText());
            } else {
                System.out.println(indent + "- " + c.getType());
            }

            // Recurse into nested content
            printContent(c.getChildren(), level + 1);

        }
    }

    /**
     * Enhanced method: prints hierarchy like bullet points
     */
    public static void printAsBullets(List<Content> contents, int level) {
        if (contents == null) return;

        for (Content c : contents) {
            String indent = "  ".repeat(level);

            // If this node has text, print it
            if (c.getText() != null) {
                System.out.println(indent + "- " + c.getText());
            }

            // If node has children, recurse
            printAsBullets(c.getChildren(), level + 1);
        }
    }
}
