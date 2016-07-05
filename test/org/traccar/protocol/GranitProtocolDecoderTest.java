package org.traccar.protocol;

import java.nio.ByteOrder;

import org.junit.Test;
import org.traccar.ProtocolTest;

public class GranitProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        GranitProtocolDecoder decoder = new GranitProtocolDecoder(new GranitProtocol());

        verifyPosition(decoder, binary(ByteOrder.LITTLE_ENDIAN,
                "2b525243427e1a003e2934757c57b8b03c38d279b4e61e9bd7006b000000001c00002a45330d0a"));
        
        verifyPositions(decoder, binary(ByteOrder.LITTLE_ENDIAN,
        		"2b444441547e84003e290401d01690737c57b8903c383c7fa0e5081b64006b000000001c0000b8803c388e7fe7e5102197006c000000001c0000b8813c38ad7f02e6042035006c000000001d0000b8813c38bf7f13e6001d1e006c000000001d0000b8813c38bf7f13e6001d00006c000000001d0000b8903c38977f34e6091065006c000000001e000014002a39320d0a"));
        
        verifyPositions(decoder, binary(ByteOrder.LITTLE_ENDIAN,
        		"2b444441547e84003e290401d41680747c57f8a03c38987f50e6005300006c000000001c0000f8b03c38987f50e6005300006c000000001c0000fefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefefe14002a43460d0a"));
        
        //+IDNT: Navigator.04x  Firmware version  0712GLN *21
        verifyAttributes(decoder, binary(ByteOrder.LITTLE_ENDIAN,
                "2b49444e543a204e6176696761746f722e30347820204669726d776172652076657273696f6e202030373132474c4e202a32310d0a"));
        
        //ERROR WRONG CHECKSUM_1
        verifyAttributes(decoder, binary(ByteOrder.LITTLE_ENDIAN,
                "4552524f522057524f4e4720434845434b53554d5f310d0a"));
    }

}
