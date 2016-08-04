package io.oversec.one.crypto.encoding;

import android.content.Context;
import io.oversec.one.crypto.R;
import io.oversec.one.crypto.encoding.pad.AbstractPadder;
import io.oversec.one.crypto.gpg.GpgCryptoHandler;
import io.oversec.one.crypto.proto.Outer;

import java.io.IOException;

public class AsciiArmouredGpgXCoder extends AbstractXCoder {

    public static final String BEGIN = "-----BEGIN PGP MESSAGE-----";
    public static final String END = "-----END PGP MESSAGE-----";

    public static final String ID = "gpg-ascii-armoured";

    public AsciiArmouredGpgXCoder(Context ctx) {
        super(ctx);
    }

    @Override
    protected String encodeInternal(Outer.Msg msg) throws IOException {
        return GpgCryptoHandler.getRawMessageAsciiArmoured(msg);
    }

    @Override
    public Outer.Msg decode(String s) throws IOException, IllegalArgumentException {
        int i = s.indexOf(BEGIN);
        if (i < 0) {
            return null;
        } else {
            int k = s.indexOf(END, i + BEGIN.length());
            if (k < 0) {
                throw new IllegalArgumentException("invalid ascii armour");
            }
        }

        return GpgCryptoHandler.parseMessageAsciiArmoured(s);
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getLabel(AbstractPadder padder) {
        return mCtx.getString(R.string.encoder_gpg_ascii_armoured);
    }

    @Override
    public String getExample(AbstractPadder padder) {
        return BEGIN;
    }


}
