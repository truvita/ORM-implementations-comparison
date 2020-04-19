package ru.jpa.tests.imp;

public interface ITestJPQLPerson extends CrudEntitier {

    void save(int num);
    void JPQLUpdate();
    void JPQLWithPagination();
    void JPQLSelect();
    void JPQLDelete();

    default void crudEntity(int num) {
        TimeBenchmark timeBenchmark = new TimeBenchmark();
        System.out.println("------------------Save");
        timeBenchmark.measure(() -> save(num));
        System.out.println("------------------JPQL Update");
        timeBenchmark.measure(this::JPQLUpdate);
        System.out.println("------------------JPQL Select");
        timeBenchmark.measure(this::JPQLSelect);
        System.out.println("------------------JPQL With Pagination");
        timeBenchmark.measure(this::JPQLWithPagination);
        System.out.println("------------------JPQL Delete");
        timeBenchmark.measure(this::JPQLDelete);
    }

}
