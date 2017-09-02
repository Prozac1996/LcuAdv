package cn.lfz.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Base64Util
{
  public static Object loadObject(String paramString, SharedPreferences paramSharedPreferences)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(Base64.decode(paramSharedPreferences.getString(paramString, null), 0));
    try
    {
      Object localObject = new ObjectInputStream(localByteArrayInputStream).readObject();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static void saveObject(Object paramObject, String paramString, SharedPreferences.Editor paramEditor)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(paramObject);
      paramEditor.putString(paramString, new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0)));
      paramEditor.commit();
      localObjectOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}

/* Location:           F:\数据\Android工具包\反编译包\jd-gui\classes_dex2jar.jar
 * Qualified Name:     cn.lfz.util.Base64Util
 * JD-Core Version:    0.6.2
 */