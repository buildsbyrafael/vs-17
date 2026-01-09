package model;

public class BatalhaEntity {
    private Integer idBatalha;
    private Integer idPersonagem;
    private Integer idInimigo;

    public BatalhaEntity() {}

    public Integer getIdBatalha() { return idBatalha; }
    public void setIdBatalha(Integer idBatalha) { this.idBatalha = idBatalha; }

    public Integer getIdPersonagem() { return idPersonagem; }
    public void setIdPersonagem(Integer idPersonagem) { this.idPersonagem = idPersonagem; }

    public Integer getIdInimigo() { return idInimigo; }
    public void setIdInimigo(Integer idInimigo) { this.idInimigo = idInimigo; }
}