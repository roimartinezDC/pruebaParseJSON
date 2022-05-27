import org.json.JSONArray;
import org.json.JSONObject;

public class ejemploParse {
    static String cadenaJSON =
            "{" +
                    "    \"pageInfo\": {" +
                    "            \"pageName\": \"Homepage\"," +
                    "            \"logo\": \"https://www.example.com/logo.jpg\"" +
                    "    }," +
                    "    \"posts\": [" +
                    "            {" +
                    "                \"post_id\": \"0123456789\"," +
                    "                \"actor_id\": \"1001\"," +
                    "                \"author_name\": \"Jane Doe\"," +
                    "                \"post_title\": \"How to parse JSON in Java\"," +
                    "                \"comments\": [\"Comentario1_1\", \"Comentario1_2\"]," +
                    "                \"time_of_post\": \"1234567890\"" +
                    "            }," +
                    "            {" +
                    "                \"post_id\": \"9876543210\"," +
                    "                \"actor_id\": \"110\"," +
                    "                \"author_name\": \"Doe Jane\"," +
                    "                \"post_title\": \"How to parse JSON in Java (1)\"," +
                    "                \"comments\": [\"Comentario2_1\", \"Comentario2_2\", \"Comentario2_3\"]," +
                    "                \"time_of_post\": \"9876543210\"" +
                    "            }" +
                    "    ]" +
                    "}";
    public static void main(String[] args) {

        JSONObject obj = new JSONObject(cadenaJSON);

        String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        System.out.println(pageName+"\n");

        JSONArray arr = obj.getJSONArray("posts");
        JSONArray arr_comments;

        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);

            arr_comments = arr.getJSONObject(i).getJSONArray("comments");
            for (int e = 0; e < arr_comments.length(); e++) {
                String comment = arr_comments.getString(e);
                System.out.println(comment);
            }
            System.out.println();
        }

    }
}
