package Interfaces;

public interface IDataModel<T> {
    boolean recordModelData(T modelReference);
    boolean updateModelData(T modelReference);
    boolean deleteModelData(T modelReference);
    T getModelData(T modelreference);
    int getTotalClass();
}
