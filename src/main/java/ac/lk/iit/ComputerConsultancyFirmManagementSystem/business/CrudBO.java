package ac.lk.iit.ComputerConsultancyFirmManagementSystem.business;

import java.util.List;

public interface CrudBO<T> extends SuperBO {

    public boolean save(T dto)  throws Exception;

    public boolean update(T dto)throws Exception;

    public boolean remove(String dtoId)throws Exception;

    public List<T> getAll() throws Exception;

    public T getById(String dtoId)throws Exception;

}
