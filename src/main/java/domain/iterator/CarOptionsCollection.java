package domain.iterator;

import java.util.ArrayList;
import java.util.List;

public class CarOptionsCollection implements IterableCollection<CarOption> {
    private List<CarOption> options = new ArrayList<>();

    public void addOption(CarOption option) {
        options.add(option);
    }

    public int getSize() {
        return options.size();
    }

    @Override
    public Iterator<CarOption> createIterator() {
        return new CarOptionsIterator(options);
    }

    private class CarOptionsIterator implements Iterator<CarOption> {
        private List<CarOption> options;
        private int position = 0;

        public CarOptionsIterator(List<CarOption> options) {
            this.options = options;
        }

        @Override
        public boolean hasNext() {
            return position < options.size();
        }

        @Override
        public CarOption next() {
            if (!hasNext()) {
                return null;
            }
            return options.get(position++);
        }
    }
}
