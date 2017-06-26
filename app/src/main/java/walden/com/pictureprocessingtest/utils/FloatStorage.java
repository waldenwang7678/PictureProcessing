package walden.com.pictureprocessingtest.utils;

/**
 * Created by Administrator on 2017/6/26 0026.
 */

public class FloatStorage {
    public static float[] greyMatrix = new float[]{   //灰度
            0.33f, 0.59f, 0.11f, 0, 0,
            0.33f, 0.59f, 0.11f, 0, 0,
            0.33f, 0.59f, 0.11f, 0, 0,
            0, 0, 0, 1, 0
    };
    public static float[] reverseMatrix = new float[]{   //反转
            -1, 0, 0, 1, 1,
            1, -1, 0, 1, 1,
            0, 0, -1, 1, 1,
            0, 0, 0, 1, 0
    };

    public static float[] oldMatrix = new float[]{   //怀旧
            0.393f, 0.769f, 0.189f, 0, 0,
            0.349f, 0.686f, 0.168f, 0, 0,
            0.272f, 0.534f, 0.131f, 0, 0,
            0, 0, 0, 1, 0
    };
    public static float[] dropColorMatrix = new float[]{   //去色
            1.5f, 1.5f, 1.5f, 0, -1,
            1.5f, 1.5f, 1.5f, 0, -1,
            1.5f, 1.5f, 1.5f, 0, -1,
            0, 0, 0, 1, 0
    };
    public static float[] highSaturation = new float[]{   //高饱和
            1.438f, -0.122f, -0.016f, 0, -0.03f,
            -0.062f, 1.378f, -0.016f, 0, 0.05f,
            -0.062f, -0.122f, 1.483f, 0, -0.02f,
            0, 0, 0, 1, 0
    };
}
