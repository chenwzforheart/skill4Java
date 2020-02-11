int main(int argc,char **argv)
{
    struct socketaddr_in peer;
    SOCKET s;
    INIT();
    set_address(argv[1],argv[2],&peer,"tcp");
    s=socket(AF_INET,SOCK_STREAM,0);
    if(!isvalidsock(s))
        error(1,errno,"socket call failed");
    if(connect(s,(struct sockaddr *)&peer,sizeof(peer)))
       error(1,errno,"connect failed");
    client(s,&peer);
    EXIT(0);
}

int readn(SOCKET fd,char *bp,size_t len)
{
    int cnt;
    int rc;
    cnt =len;
    while (cnt>0)
    {
        rc=recv(fd,bp,cnt,0);
        if(rc<0)
        {
            if(errno == EINTR)
                continue;
                return -1;
        }
        if(rc==0)
            return len-cnt;
        bp+=rc;
        cnt-=rc;
    }
    
}

int readrec(SOCKET fd,char *bp,size_t len)
{
    u_int32_t reclen;
    int rc;
    /**Retrieve the length of the record */
    rc=readn(fd,(char *)&reclen,sizeof(u_int32_t));
    if(rc!=sizeof(u_int32_t))
        return rc<0?-1:0;
    reclen =ntoh1(reclen);
    if(reclen>len)
    {
        /*
        *Not enough room for the record --
        *discard it and return an error. 
        */
       while(reclen >0)
       {
           rc=readn(fd,bp,len);
           if(rc!=len)
            return rc<0?-1:0;
            reclen-=len;
            if(reclen<len)
                len=reclen;
       }
       set_errno(EMSGSIZE);
       return -1;
    }
    /*Retrieve the record itself*/
    rc=readn(fd,bp,reclen);
    if(rc!=reclen)
        return rc<0?-1:0;
    return rc;
}