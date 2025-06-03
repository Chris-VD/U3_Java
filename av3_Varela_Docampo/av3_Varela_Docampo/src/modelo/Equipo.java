package modelo;

import java.util.ArrayList;

import modelo.Enums.ProvinciasEnum;
import modelo.Enums.RolesEnum;
import modelo.Excepcions.XogadoresCheosExcepcion;
import utils.Utils;

public class Equipo implements LoginInterfaz{
    private String nome;
    private String cidade;
    private String correo;
    private String hash;
    private ProvinciasEnum provincia;
    private ArrayList<Xogador> xogadores;

    public Equipo(String nome, String cidade, String psswd, ProvinciasEnum provincia){
        this.nome = nome;
        this.cidade = cidade;
        this.provincia = provincia;
        this.setCorreo();
        this.setHash(psswd);
        this.xogadores = new ArrayList<>();
    }

    public void xogarPartido(){
        for (Xogador xogador:xogadores){
            xogador.xogarPartido();
        }
    }

    @Override
    public String toString(){
        return getNome() + " de " + getCidade();
    }

    public void engadirxogador(Xogador xogador) throws XogadoresCheosExcepcion{
        if (xogadores.size() >= 15) throw new XogadoresCheosExcepcion("Non s epoden engadir máis xogadore sa este equipo.");
        else xogadores.add(xogador);
    }
    private void setCorreo(){
        this.correo = getNome().toLowerCase().strip() + "." + getCidade().toLowerCase().strip() + "@fgb.gal";
    }
    public void setHash(String psswd){
        this.hash = Utils.hashPassword(psswd);
    }
    public RolesEnum getRol(){
        return RolesEnum.EQUIPO;
    }
    public ArrayList<Xogador> getXogadores(){
        return xogadores;
    }
    public String getNome(){
        return nome;
    }
    public String getCorreo(){
        return correo;
    }
    public String getHash(){
        return hash;
    }
    public String getCidade(){
        return cidade;
    }
    public ProvinciasEnum getProvinciaRaw(){
        return provincia;
    }
    public String getProvincia(){
        String prov;
        switch (provincia) {
            case ProvinciasEnum.ACORUNA-> {
                prov = "A Coruña";
            }
            case ProvinciasEnum.OURENSE-> {
                prov = "Ourense";
            }
            case ProvinciasEnum.LUGO-> {
                prov = "Lugo";
            }
            case ProvinciasEnum.PONTEVEDRA-> {
                prov = "Pontevedra";
            }
            default -> {
                prov = "None";
            }
        }
        return prov;
    }
}
