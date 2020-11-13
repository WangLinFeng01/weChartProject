package com.wechat.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.FileUtil;

//对海报进行加对应的文字水印和图片水印
public class ImageUtil {
	
	//str --- 用户头像的相对地址  ,,直接将海报的地址写死，直接写上去
	public static String pressImage(String headPath,String qrcodeImgPath) {
		String strPath = headPath.substring(0, headPath.lastIndexOf("."))+"1.jpg";
		File targetfile = FileUtil.file(strPath);
		
		//判断这个海报是否存在，存在就直接返回这个strPath这个路径
		//TODO   判断这个海报是否在临时素材库中是否有效，失效就不执行if语句 
		if(targetfile.exists()) {
			return strPath;
		}
		
		File file = FileUtil.file(strPath);
		ImgUtil.pressText(//
				FileUtil.file("../../img/haiBao.png"), //海报源地址
				file,  //目标地址
			    "", Color.black, //文字
			    new Font("黑体", Font.BOLD, 20), //字体
			    50, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0.8f//透明度：alpha 必须是范围 [0.0, 1.0] 之内（包含边界值）的一个浮点数字
			);

		//先对二维码进行缩放处理   (注意：缩放和剪切只需要执行一次，必须要加以限制)
		scaleMethod(qrcodeImgPath,qrcodeImgPath,0.5f);
		
		//对头像进行裁剪为园的形状
//		Test2.cricleMethod(headPath,headPath);
		
		//对头像进行缩放处理
		scaleMethod(headPath,headPath,0.65f);
		
		
//		//添加二维码水印
		ImgUtil.pressImage(
				file, 
				file, 
				ImgUtil.read(FileUtil.file(qrcodeImgPath)), //水印图片
				230, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
				510, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
				0.9f
				);

		//添加微信头像水印
		ImgUtil.pressImage(
				file, 
				file, 
			    ImgUtil.read(FileUtil.file(headPath)), //水印图片
			    -299, //x坐标修正值。 默认在中间，偏移量相对于中间偏移
			    -582, //y坐标修正值。 默认在中间，偏移量相对于中间偏移
			    0.9f
			);
		System.out.println("执行完成");
		return strPath;
	}

	/**
	 * 
	 * @param Path  源地址
	 * @param targetPath 目标地址
	 * @return 目标图片的地址字符串表示
	 */
	
	//裁剪圆形的图片   返回在本图片上。可以重新生成一张图片
	public static String cricleMethod(String Path,String targetPath) {
		File imageFile=new File(Path); 
		Image src = ImgUtil.read(imageFile);
		Image cricle = ImgUtil.cut(src, 0, 0,0);//得到了进行圆角切割的图片
		File targetFile = new File(targetPath);
		ImgUtil.write(cricle, targetFile);
		System.out.println("完成");
		return targetPath;
	}
	/**
	 * 
	 * @param Path : 源地址
	 * @param targetPath ： 目标地址
	 * @param f ： 缩放的倍数 ，比如：0.3f
	 * @return 目标地址的字符串表示
	 */
	//图片的缩放
	public static String scaleMethod(String Path,String targetPath,float f) {
		ImgUtil.scale(
			    FileUtil.file(Path),
			    FileUtil.file(targetPath),
			    f//缩放比例
			);
		return targetPath;
	}
	
	//创建文件夹如果不存在  主要用于自动在Tomcat运行时创建文件夹img
	public static void createFiles(File file) {
		//获取父目录
		 if(!file.exists()) {
			 file.mkdirs();
		 }
//		 f.getParentFile().mkdirs();
//		f.createNewFile();  注意这个是创建最后一个路径是文件的方法
	}

	public static BufferedImage change2jpg(File f) {
		try {
			java.awt.Image i = Toolkit.getDefaultToolkit().createImage(f.getAbsolutePath());
			PixelGrabber pg = new PixelGrabber(i, 0, 0, -1, -1, true);
			pg.grabPixels();
			int width = pg.getWidth(), height = pg.getHeight();
			final int[] RGB_MASKS = { 0xFF0000, 0xFF00, 0xFF };
			final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);
			DataBuffer buffer = new DataBufferInt((int[]) pg.getPixels(), pg.getWidth() * pg.getHeight());
			WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
			BufferedImage img = new BufferedImage(RGB_OPAQUE, raster, false, null);
			return img;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static void resizeImage(File srcFile, int width,int height, File destFile) {
		try {
			if(!destFile.getParentFile().exists())
				destFile.getParentFile().mkdirs();
			Image i = ImageIO.read(srcFile);
			i = resizeImage(i, width, height);
			ImageIO.write((RenderedImage) i, "jpg", destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Image resizeImage(Image srcImage, int width, int height) {
		try {

			BufferedImage buffImg = null;
			buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			buffImg.getGraphics().drawImage(srcImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

			return buffImg;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
