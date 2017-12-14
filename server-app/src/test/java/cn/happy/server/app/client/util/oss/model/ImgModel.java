package cn.happy.server.app.client.util.oss.model;

import org.forkjoin.apikit.core.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * Created by Happy on 17-9-25.
 图片模型
 */
public class ImgModel implements ApiMessage {

	/**
	 * 图片键
	 */
	private String imgKey;

	/**
	 * 图片宽：像素px
	 */
	private int imgW;

	/**
	 * 图片高：像素px
	 */
	private int imgH;

	public ImgModel() {
	}

	public ImgModel(String imgKey, int imgW, int imgH) {
		this.imgKey = imgKey;
		this.imgW = imgW;
		this.imgH = imgH;
	}

	/**
	 * 图片键
	 */
	public String getImgKey() {
		return imgKey;
	}

	/**
	 * 图片键
	 */
	public void setImgKey(String imgKey) {
		this.imgKey = imgKey;
	}

	/**
	 * 图片宽：像素px
	 */
	public int getImgW() {
		return imgW;
	}

	/**
	 * 图片宽：像素px
	 */
	public void setImgW(int imgW) {
		this.imgW = imgW;
	}

	/**
	 * 图片高：像素px
	 */
	public int getImgH() {
		return imgH;
	}

	/**
	 * 图片高：像素px
	 */
	public void setImgH(int imgH) {
		this.imgH = imgH;
	}

	@Override
	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		if (imgKey != null) {
			$list.add(new SimpleImmutableEntry<>($parent + "imgKey", imgKey));
		}

		$list.add(new SimpleImmutableEntry<>($parent + "imgW", imgW));

		$list.add(new SimpleImmutableEntry<>($parent + "imgH", imgH));

		return $list;
	}

	@Override
	public String toString() {
		return "ImgModel [imgKey=" + imgKey + ",imgW=" + imgW + ",imgH=" + imgH + ", ]";
	}
}