package fa.training.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "VE")
public class Ve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id;
	
	@ManyToOne
	@JoinColumn(name = "maSuatChieu")
	SuatChieu suatChieu;
	
	@ManyToOne
	@JoinColumn(name = "maKhachHang")
	KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name = "maKhuyenMai")
	KhuyenMai khuyenMai;
	
	@Column(columnDefinition = "Nvarchar(50)")
	String status;
	
	@Column(name = "MaGhe",columnDefinition = "varchar(7)")
	@Pattern(regexp = "^[A-Z]{1}[0-9]{1-2}$", message = "mã ghế không đúng định dạng [A-Z]xx")
	String maGhe;

	public Ve() {
	}

	public Ve(SuatChieu suatChieu, KhachHang khachHang, KhuyenMai khuyenMai, String status,String maGhe) {
		this.suatChieu = suatChieu;
		this.khachHang = khachHang;
		this.khuyenMai = khuyenMai;
		this.status = status;
		this.maGhe = maGhe;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public SuatChieu getSuatChieu() {
		return suatChieu;
	}

	public void setSuatChieu(SuatChieu suatChieu) {
		this.suatChieu = suatChieu;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}

	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getDonGia() {
		return maGhe;
	}

	public void setDonGia(String maGhe) {
		this.maGhe = maGhe;
	}

	@Override
	public String toString() {
		return String.format("Ve [Id=%s, suatChieu=%s, khachHang=%s, khuyenMai=%s, status=%s, maGhe=%s]", Id,
				suatChieu, khachHang, khuyenMai, status, maGhe);
	}



	
	
}
