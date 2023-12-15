package registers;
import models.application.Cliente;
import models.application.Pet;
public class CadastroCliente {
    public boolean cadastrarCliente(Cliente cliente) {
        if(buscarPorCpf(cliente.getCpf()) != null){
            //dao
            return true;
        }
        

        return false;
    }

    public Cliente buscarPorCpf(String cpf) {
        // for (Cliente cliente : clientes) {
            return cliente;
        // }
        return null;
    }

    // public boolean removerCliente(String cpf){
    //     Cliente clienteRem = buscarPorCpf(cpf);
    //     //dao
    //     clientes.remove(clienteRem);
    // }


    public boolean cadastrarPet(Pet pet){
        if (buscarPetPorCodigo(pet.getCodigo()) != null){
            pet.getTutor().getPets().add(pet);
            //dao
            return true;

        }
        return false;
    }

    public Pet buscarPetPorCodigo(int codigo){
         // for (Pet pet : pets) {
            return pet;
        // }
        return null;
    }

    // public boolean removerPet(int codigo){
    //     Pet petRem = buscarPetPorCodigo(codigo);
    //     //dao
    //     petRem.getTutor().getPets().remove(petRem);
    // }




}