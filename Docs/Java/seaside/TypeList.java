import java.util.ArrayList;
import java.util.List;

public class TypeList<T> {
        private List<T> list = new ArrayList<>();

        public void add (T value){
            this.list.add(value);
        }
        public T get (int index){
            return this.list.get(index);
        }
        public int size(){
            return this.list.size();
        }

}
