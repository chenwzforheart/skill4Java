#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdarg.h>
#include <string.h>
#include <errno.h>
#include <netdb.h>
#include <fcntl.h>
#include <sys/time.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include "skel.h"

char *program_name;

int main(int argc,char **argv)
{
    struct sockaddr_in local;
    struct sockaddr_in peer;
    char *hname;
    char *sname;
    int peerlen;
    SOCKET s1;
    SOCKET s;
    const int on =1;

    INIT();

    if(argc == 2)
    {
        hname = NULL;
        sname = argv[1];
    }
    else
    {
        hname = argv[1];
        sname = argv[2];
    }

    set_address(hname,sname,&local,"tcp");
    s=socket(AF_INET,SOCK_STREAM,0);
    if(!isvalidsock(s))
        error(1,errno,"socket call failed");
    if(setsocket(s,SOL_SOCKET,SO_REUSEADDR,&on,sizeof(on)))
        error(1,errno,"setsocketopt failed");
    if(bind(s,(struct sockaddr *)&local,sizeof(local)))
        error(1,errno,"bind failed")
    do
    {
        peerlen = sizeof(peer);
        sl=accept(s,(struct sockaddr *)&peer,&peerlen);
        if(!isvalidsock(s1))
            error(1,errno,"accept failed");
        server(s1,&peer);
        CLOSE(s1);
    } while (1);
    EXIT(0);
}

static void set_address(char *hname,char *sname,
    struct sockaddr_in *sap,char *protocol)
{
    struct servent *sp;
    struct hostent *hp;
    char *endptr;
    short port;

    bzero(sap,sizeof(*sap));
    sap->sin_family = AF_INET;
    if(hname != NULL)
    {
        if(!inet_aton(hname,&sap->sin_addr))
        {
            hp=gethostbyname(hname);
            if(hp == NULL)
                error(1,0,"unknown host:%s\n",hname);
            sap->sin_addr = *(struct in_addr *)hp->h_addr;
        }
    }
    else
    {
        sap->sin_addr.s_addr = htonl(INADDR_ANY);
    }
    prot = strtol(sname,&endptr,0);
    if(*endptr == '\0')
        sap->sin_port = htons(port);
    else
    {
        sp=getservbyname(sname,protocol);
        if(sp==NULL)
            error(1,0,"unknown service:%s\n",sname);
        sap->sin_port=sp->s_port;
    }
}

void error(int status,int err,char *format,...)
{
    va_list ap;
    va_strat(ap,fmt);
    fprintf(stderr,"%s: ",program_name);
    vfprintf(stderr,fmt,ap);
    va_end(ap);
    if(err)
        fprintf(stderr,":%s (%d)\n",strerror(err),err);
    if(status)
        EXIT(status);
}