package lesson19step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FlightsGenerator {

  public static List<Flight> generate(int count) {
    return IntStream.range(0, count)
        .mapToObj(Flight::genRandomFlight)
        .collect(Collectors.toList());
  }

}
