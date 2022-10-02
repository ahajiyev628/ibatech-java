package lesson23sql1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


interface MyFunction<A, B> {
  B apply (A a) throws Exception;
}

public class SQLSelectApp {

  static <A> List<A> remapResultSet(ResultSet result, MyFunction<ResultSet, A> f) throws Exception {
    ArrayList<A> x = new ArrayList<>();
    while (result.next()) {
      A p = f.apply(result);
      x.add(p);
    }
    return x;
  }

  public static void main(String[] args) throws Exception {
    Connection conn = DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/be5",
        "postgres",
        "pg123456"
    );
    PreparedStatement st = conn.prepareStatement("select * from person where name ilike ?");
    st.setString(1, "al%");
    ResultSet result = st.executeQuery();

//    while (result.next()) {
//      int id = result.getInt("id");
//      String name = result.getString("name");
//      System.out.printf("%d : %s\n", id, name);
//    }

    List<Person> typedResult = remapResultSet(result, Person::fromResultSet);
    typedResult.forEach(x -> System.out.println(x));
  }


}
