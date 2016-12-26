package predicate;

/**
 * Created by laura on 26.12.16.
 */

    public interface Predicate<T> {
        /**
         * Method which tests an element against the predicate
         *
         * @param element The element which is being tested
         * @return true if predicate applies
         */
        public boolean test(T element);

    }

