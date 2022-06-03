package homework2;

import java.util.List;
import java.util.Map;

public class edge<T> {
    private T edgeLabel;
    private T src;
    private Map<T, List<T>> parentNodes;
    private Map<T, List<T>> childrenNodes;

}
