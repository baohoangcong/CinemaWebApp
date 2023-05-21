package fa.training.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "DICHVU")
public class DichVu {
	@Id
	@Pattern(regexp = "^DV[0-9]{5}$",message ="Mã dịch vụ không đúng định dạng (DVxxxxx)")
	String maDichVu;
	
	@Column(columnDefinition = "Nvarchar(50)")
	@Length(min = 3,max = 50, message = "Tên dịch vụ từ 3-50 kí tự")
	String tenDichVu;
	
	@Column(columnDefinition = "Ntext")
	String moTaDichVu;
	
	@Pattern(regexp = "^[+]?\\b[0-9]+\\b$", message = "Đơn giá phải là number")
	@Range(min = 0, message = "Đơn giá không được nhỏ hơn 0")
	Integer donGia;
	
	@OneToMany(mappedBy = "dichVu",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	Set<SuDungDichVu> suDungDichVu;

	public DichVu() {
	}

	public DichVu(String maDichVu, String tenDichVu, String moTaDichVu, int donGia) {
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.moTaDichVu = moTaDichVu;
		this.donGia = donGia;
	}

	public DichVu(String maDichVu, String tenDichVu, String moTaDichVu, int donGia, Set<SuDungDichVu> suDungDichVu) {
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.moTaDichVu = moTaDichVu;
		this.donGia = donGia;
		this.suDungDichVu = suDungDichVu;
	}

	public String getMaDichVu() {
		return maDichVu;
	}

	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}

	public String getTenDichVu() {
		return tenDichVu;
	}

	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}

	public String getMoTaDichVu() {
		return moTaDichVu;
	}

	public void setMoTaDichVu(String moTaDichVu) {
		this.moTaDichVu = moTaDichVu;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public Set<SuDungDichVu> getSuDungDichVu() {
		return suDungDichVu;
	}

	public void setSuDungDichVu(Set<SuDungDichVu> suDungDichVu) {
		this.suDungDichVu = suDungDichVu;
	}

	@Override
	public String toString() {
		return String.format("DichVu [maDichVu=%s, tenDichVu=%s, moTaDichVu=%s, donGia=%s, suDungDichVu=%s]", maDichVu,
				tenDichVu, moTaDichVu, donGia, suDungDichVu);
	}
	
	
}
