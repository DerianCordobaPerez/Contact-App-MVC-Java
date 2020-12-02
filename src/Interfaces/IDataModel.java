package Interfaces;

public interface IDataModel<T> {
    public boolean recordModelData(T modelReference);
    public boolean updateModelData(T modelReference);
    public boolean deleteModelData(T modelReference);
}
