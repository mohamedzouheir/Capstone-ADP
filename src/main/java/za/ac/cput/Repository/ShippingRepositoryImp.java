package za.ac.cput.Repository;
import za.ac.cput.Domain.Shipping;
import java.util.*;

public class ShippingRepositoryImp implements IShippingRepository<Shipping,String> {
    private List<Shipping> shippingList;
    public ShippingRepositoryImp(){
        shippingList = new ArrayList<Shipping>();
    }

    @Override
    public Shipping create(Shipping obj) {
        boolean success = shippingList.add(obj);
        if (success) {
            return obj;
        }
        return null;
    }

    @Override
    public Shipping read(String id) {
        for (Shipping sh : shippingList) {
            if (sh.getShippingID().equals(id))
                return sh;
        }
        return null;
    }

    @Override
    public Shipping update(Shipping obj) {
        Shipping shippingOld = read(obj.getShippingID());

        boolean success = shippingList.remove(shippingOld);
        if (success) {
            if (shippingList.add(obj))
                return obj;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Shipping shippingToDelete = read(id);
        boolean success = shippingList.remove(shippingToDelete);
        return success;
    }

    @Override
    public List<Shipping> getAll() {
        return shippingList;
    }
}


